import os
import re
import docx2txt
import nltk
import datetime as dt
from utils.job_data import JOB_LIST, SKILL_LIST, SCHOOL_DICT
from pdfminer.high_level import extract_text

class Resume:
    def __init__(self, resume):
        self.__resume = resume
        self.__file_ext = os.path.splitext(resume)[1]
        
    def extract(self):
        resume_text = self.extract_text()
        name = self.__get_name(resume_text)
        phone_number = self.__get_phone(resume_text)
        email = self.__get_email(resume_text)
        skills = self.__get_skills(resume_text)
        school = self.__get_school(resume_text)
        experience = self.__get_experience(resume_text)
        
        return {
            "name": name,
            "contact": {
                "phone": phone_number,
                "email": email
            },
            "skills": skills,
            "education": school,
            "experience": experience
        }
        
    def extract_text(self):
        match self.__file_ext:
            case ".pdf":
                return self.__extract_pdf()
            case ".docx":
                return self.__extract_docx()
        return self.__resume

    def __extract_pdf(self):
        resume_text = extract_text(self.__resume)
        return resume_text
  
    def __extract_docx(self):
        resume_text = docx2txt.process(self.__resume)
        if resume_text:
            return resume_text.replace('\t', '')
        return ""
      
    def __get_name(self, txt):
        names = []
        for sent in nltk.sent_tokenize(txt):
            for chunk in nltk.ne_chunk(nltk.pos_tag(nltk.word_tokenize(sent))):
                if hasattr(chunk, 'label') and chunk.label() == 'PERSON':
                    names.append(
                        ' '.join(chunk_leave[0] for chunk_leave in chunk.leaves())
                    )
        return names[0]
    
    def __get_phone(self, txt):
        PHONE_NUM_PATTERN = re.compile(r'[\+\(]?[1-9][0-9 .\-\(\)]{8,}[0-9]')
        
        phone_num = PHONE_NUM_PATTERN.findall(txt)
        if phone_num:
            number = ''.join(phone_num[0])
            
            if txt.find(number) >= 0 and len(number) < 16:
                return number
        
        return number
      
    def __get_email(self, txt):
        EMAIL_PATTERN = re.compile(r'[a-z0-9\.\-+_]+@[a-z0-9\.\-+_]+\.[a-z]+')
        email = EMAIL_PATTERN.findall(txt)[0]
        
        return email
      
    def __get_skills(self, txt):
        stop_words = set(nltk.corpus.stopwords.words('english'))
        word_tokens = nltk.tokenize.word_tokenize(txt)

        filtered_tokens = [w for w in word_tokens if w not in stop_words]
        filtered_tokens = [w for w in word_tokens if w.isalpha()]

        bigrams_trigrams = list(map(' '.join, nltk.everygrams(filtered_tokens, 2, 3)))

        found_skills = []

        for token in filtered_tokens:
            if token.lower() in SKILL_LIST:
                found_skills.append(token)

        for ngram in bigrams_trigrams:
            if ngram.lower() in SKILL_LIST:
                found_skills.append(ngram)

        return found_skills
      
    def __get_school(self, txt):
        candidate_school = {
            "school": "none",
            "score": 1
        }
        uni_keywords = set(["University", "College", "Academy"])
        
        #in every line of the resume...
        for line in txt.splitlines():
            #check to see if a university name...
            for keyword in uni_keywords:
                #is in this line
                if keyword in line:
                    #then see if it matches any in the list...
                    for school in SCHOOL_DICT:
                        if school in line:
                            candidate_school = {
                                "school": school,
                                "score": SCHOOL_DICT[school]
                            }
                            return candidate_school
        
        return candidate_school
      
    def __get_experience(self, txt):
        exp = {}
      
        year_to_date = int(dt.datetime.today().year)
        EXPERIENCE_PATTERN = re.compile(r"(.*((J(an(uary|\.?)|u(n(e|\.?)|l(y|\.?)))|Feb(ruary|\.?)|Ma(r(ch|\.?)|y)|A(pr(il|\.?)|ug(ust|\.?))|Sept|Nov|Dec(ember|\.?)|Oct(ober|\.?)).*\d{4}((T(O|o))?).*)(P(RESENT|resent))?)")
        YEAR_PATTERN = re.compile(r"((19|20)\d{2}|(P(RESENT|resent)))")
        
        work_experience = []
        experience_ranges = EXPERIENCE_PATTERN.findall(txt)
        for ranges in experience_ranges:
            work_experience.append(ranges[0])
        
        for experience in work_experience:
            for job in JOB_LIST:
                if job in experience.lower():
                    years = YEAR_PATTERN.findall(experience)
        
        new_years = []
        for i in range(len(years)):
            if years[i][0].lower() != "present":
                new_years.append(int(years[i][0]))
            else:
                new_years.append(int(year_to_date))
            
        exp = {
            "start_date": new_years[0], 
            "end_date": new_years[1]
        }
        
        return exp