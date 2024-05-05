import csv
#Reading the data from the given file.
def readData(inputFileName):
    suspicious = []
    with open(inputFileName, mode='r', encoding='utf-8') as file:
        reader = csv.DictReader(file)
        for record in reader:
            totalLogins = int(record['Total Logins'])
            firstIp = record['IP Address List'].split(';')[0].strip()
            if totalLogins >= 200 or 'e' in record['Last Name'].lower() or 'i' in record['Last Name'].lower():
                loginExcess = totalLogins - 199 if totalLogins >= 200 else 0
                suspicious.append({
                    #Assign Dict values
                    'name': f"{record['First Name']} {record['Last Name']}",
                    'firstIp': firstIp,
                    'loginCount': totalLogins,
                    'loginExcess': loginExcess
                })
    return suspicious
# Creates suspicious login file and prints to command line.
def susLoginsFile(suspicious, outputFilename):
    with open(outputFilename, mode='w', newline='', encoding='utf-8') as file:
        writer = csv.DictWriter(file, fieldnames=['name', 'firstIp', 'loginCount', 'loginExcess'])
        writer.writeheader()
        writer.writerows(suspicious)
    
    print("Suspicious Employee Accounts")
    print(f"{'Name':<30} {'First IP':<20} {'Login Count':<12} {'Excess Logins':<15}")
    print("-" * 80)
    for s in suspicious:
        print(f"{s['name']:<30} {s['firstIp']:<20} {s['loginCount']:<12} {s['loginExcess']:<15}")
    print("-" * 80)
    print(f"Total employees with suspicious logins: {len(suspicious)}")
#Calls first two methods and declares files.
def main():
    inputFileName = 'employee_logins.csv'
    outputFilename = 'Morgank16.csv'
    suspiciousRecords = readData(inputFileName)
    susLoginsFile(suspiciousRecords, outputFilename)

if __name__ == "__main__":
    main()
