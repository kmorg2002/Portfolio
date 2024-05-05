def get_and_validate_talk_time():
    planType = input("Plan Type: C/c for Commercial, R/r for Residential, S/s for Student: ").lower()
    minutesTalked = input("Talk Minutes: Whole number only: ")

    while planType not in ['c', 'r', 's']:
        print("Invalid plan type. Please enter C/c, R/r, or S/s.")
        planType = input("Plan Type: C/c for Commercial, R/r for Residential, S/s for Student: ").lower()

    while True:
        try:
            valMinutesTalked = int(minutesTalked)
            if valMinutesTalked < 0 or valMinutesTalked > 10080:
                print("Invalid input for talk minutes. Enter a number between 0 and 10080")
                minutesTalked = input("Talk Minutes: Whole number only: ")
                continue  # Add continue here to go back to the start of the loop
            else:
                return planType, valMinutesTalked
        except ValueError:
            print("Invalid input for talk minutes. Please enter a whole number.")
            minutesTalked = input("Enter talk minutes (whole number only): ")

def calculate_talk_time(planType, valMinutesTalked):
    if planType == 'c':
        if valMinutesTalked <= 300:
            return 0.20 * valMinutesTalked - 25.00
        else:
            return 0.20 * 300 + ((valMinutesTalked - 300) * 0.10) - 25.00
    elif planType == 'r':
        if valMinutesTalked <= 120:
            return 0.10 * valMinutesTalked - 25.00
        else:
            return 0.10 * 120 + ((valMinutesTalked - 120) * 0.05) - 25.00
    elif planType == 's':
        return 0.15 * valMinutesTalked - 25.00

def main():
    customerInfo = []

    for customerID in range(1, 5):
        print(f"Customer {customerID}:")

        planType, valMinutesTalked = get_and_validate_talk_time()
        totalDue = calculate_talk_time(planType, valMinutesTalked)

        if totalDue >= 0:
            creditDebit = f"Amount due: ${totalDue:.2f}"
        else:
            creditDebit = f"Remaining Credit: ${abs(totalDue):.2f}"

        customerInfo.append((customerID, planType.upper(), valMinutesTalked, creditDebit))

    print("\nWeekly Report - All Customers")
    print("Customer ID\tPlan Type\t# Minutes\tAmount Due/Credit")
    print("-" * 65)

    for customerInfo in customerInfo:
        print(f"{customerInfo[0]}\t\t{customerInfo[1]}\t\t{customerInfo[2]}\t\t{customerInfo[3]}")

if __name__ == "__main__":
    main()