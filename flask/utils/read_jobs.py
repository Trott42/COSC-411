import re
import pandas as pd

job_df = pd.read_csv(r"C:\Users\16162\OneDrive\Desktop\Computer Science\School\COSC 411\Project\COSC-411\flask\data\jobs.csv")

key_skills = {}

for entry in job_df["Key Skills"]:
    skills = entry.split("| ")
    for skill in skills:
      if skill not in key_skills:
          key_skills[skill] = 0
      else:
          key_skills[skill] += 1

with open("jobs.py", 'w') as job_list:
    job_list.write("JOB_LIST = [\n")
    for skill in key_skills:
        job_list.write("\"" + skill.strip().lower() + "\",\n")
    job_list.write("]")