import os
import re
import docx2txt
import nltk
from jobs import JOB_LIST
from pdfminer.high_level import extract_text

class Resume:
    def __init__(self, resume: str) -> None:
        self.__resume = resume
        self.__file_ext = os.path.splitext(resume)[1]
        
    def extract(self) -> any:
        resume_text = self.extract_text()
        
        return {
            "name": self.__get_name(resume_text),
            "contact": {
                "phone": self.__get_phone(resume_text),
                "email": self.__get_email(resume_text)
            }
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