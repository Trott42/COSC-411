import re
import pandas as pd

job_df = pd.read_csv(r"C:\Users\16162\OneDrive\Desktop\Computer Science\School\COSC 411\Project\COSC-411\flask\data\jobs.csv")

job_titles = {}

for entry in job_df["Job Title"]:
    titles = entry.split(" ")
    for title in titles:
        if title not in job_titles:
            job_titles[title] = 0
        else:
            job_titles[title] += 1

with open("jobs.txt", 'w') as job_list:
    job_list.write("JOB_LIST = [\n")
    for title in job_titles:
        if job_titles[title] >= 3:
            job_list.write("\t\"" + title.strip().lower() + "\",\n")
    job_list.write("]")