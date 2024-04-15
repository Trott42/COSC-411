from pyresparser import ResumeParser

data = ResumeParser(r"C:\Users\16162\OneDrive\Documents\Resume\Job Search\Home version\Thacker, Luke - Resume.pdf") \
    .get_extracted_data()

print(data)
