import re
import pandas as pd

job_df = pd.read_csv(r"C:\Users\16162\OneDrive\Desktop\Computer Science\School\COSC 411\Project\COSC-411\flask\data\jobs.csv")

job_titles = {}

for entry in job_df["Job Title"]:
    if entry not in job_titles:
        job_titles[entry] = 0
    else:
        job_titles[entry] += 1

for job_title in job_titles:
    if job_titles[job_title] > 0:
        print(job_title)