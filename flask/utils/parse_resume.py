from Resume import Resume

if __name__ == "__main__":
    resume = Resume(r"C:\Users\16162\OneDrive\Documents\Resume\Job Search\Home version\Thacker, Luke - Resume.pdf")
    print(resume.extract_text())
    print(resume.extract())