import os
import re
import docx2txt
import nltk
from job_data import SKILL_LIST, SCHOOL_DICT
from pdfminer.high_level import extract_text

class Resume:
    def __init__(self, resume: str) -> None:
        self.__resume = resume
        self.__file_ext = os.path.splitext(resume)[1]
        
    def extract(self) -> any:
        resume_text = self.extract_text()
        name = self.__get_name(resume_text)
        phone_number = self.__get_phone(resume_text)
        email = self.__get_email(resume_text)
        skills = self.__get_skills(resume_text)
        school = self.__get_school(resume_text)
        
        return {
            "name": name,
            "contact": {
                "phone": phone_number,
                "email": email
            },
            "skills": skills,
            "education": school,
        }
        
    def extract_text(self) -> str:
        match self.__file_ext:
            case ".pdf":
                return self.__extract_pdf()
            case ".docx":
                return self.__extract_docx()
        return self.__resume

    def __extract_pdf(self) -> str:
        resume_text = extract_text(self.__resume)
        return resume_text
  
    def __extract_docx(self) -> str:
        resume_text = docx2txt.process(self.__resume)
        if resume_text:
            return resume_text.replace('\t', '')
        return ""
      
    def __get_name(self, txt: str) -> str:
        names = []
        for sent in nltk.sent_tokenize(txt):
            for chunk in nltk.ne_chunk(nltk.pos_tag(nltk.word_tokenize(sent))):
                if hasattr(chunk, 'label') and chunk.label() == 'PERSON':
                    names.append(
                        ' '.join(chunk_leave[0] for chunk_leave in chunk.leaves())
                    )
        return names[0]
    
    def __get_phone(self, txt: str) -> str:
        PHONE_NUM_PATTERN = re.compile(r'[\+\(]?[1-9][0-9 .\-\(\)]{8,}[0-9]')
        
        phone_num = PHONE_NUM_PATTERN.findall(txt)
        if phone_num:
            number = ''.join(phone_num[0])
            
            if txt.find(number) >= 0 and len(number) < 16:
                return number
        
        return number
      
    def __get_email(self, txt: str) -> str:
        EMAIL_PATTERN = re.compile(r'[a-z0-9\.\-+_]+@[a-z0-9\.\-+_]+\.[a-z]+')
        email = EMAIL_PATTERN.findall(txt)[0]
        
        return email
      
    def __get_skills(self, txt: str) -> set[str]:
        stop_words = set(nltk.corpus.stopwords.words('english'))
        word_tokens = nltk.tokenize.word_tokenize(txt)

        filtered_tokens = [w for w in word_tokens if w not in stop_words]
        filtered_tokens = [w for w in word_tokens if w.isalpha()]

        bigrams_trigrams = list(map(' '.join, nltk.everygrams(filtered_tokens, 2, 3)))

        found_skills = set()

        for token in filtered_tokens:
            if token.lower() in SKILL_LIST:
                found_skills.add(token)

        for ngram in bigrams_trigrams:
            if ngram.lower() in SKILL_LIST:
                found_skills.add(ngram)

        return found_skills
      
    def __get_school(self, txt: str) -> dict[str]:
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