import os
import shutil
import subprocess as sp
import zipfile as zf
import time

# create the backup
def backup_dir(srcDir, destDir):
    if not os.path.exists(srcDir):
        raise Exception(f"The Source directory {srcDir} does not exist.")
    if not os.path.exists(destDir):
        os.makedirs(destDir)
    sp.call(["rsync", "-a", srcDir, destDir])

# create archive
def archive_dir(srcDir, archType):
    acceptableTypes = ["zip", "tar"]
    if not (archType in acceptableTypes):
        raise Exception(f"{archType} is not in the list of acceptable types {acceptableTypes}")
    archive_name = os.path.join(os.path.dirname(srcDir), os.path.basename(srcDir))
    shutil.make_archive(archive_name, archType, srcDir)

# Inspect Zip File
def inspect_zip(zip_path, threshold_kb):
    if not zf.is_zipfile(zip_path):
        raise Exception("Invalid zip file.")
    with zf.ZipFile(zip_path, 'r') as zipf:
        for info in zipf.infolist():
            size_kb = info.file_size / 1024
            if size_kb > threshold_kb:
                os_name = "Windows" if info.create_system == 0 else "Unix"
                print(f"{info.filename} | {size_kb:.2f} KB | {os_name}")

# Modified in the Last Month
def modified_last_month(directory):
    if directory is None or not os.path.exists(directory):
        directory = os.getcwd()
    current_time = time.time()
    thirty_days_ago = current_time - (30 * 24 * 60 * 60)
    for root, dirs, files in os.walk(directory):
        for file in files:
            path = os.path.join(root, file)
            if os.path.getmtime(path) > thirty_days_ago:
                print(f"{path}")

# Main Menu
def main_menu():
    while True:
        choice = input("\n1. Backup Directory\n2. Archive Directory\n3. Inspect Zip File\n4. Modified Files in Last Month\n5. Exit\nChoose: ")
        if choice == "1":
            srcDir = input("Source directory: ")
            destDir = input("Destination directory: ")
            try:
                backup_dir(srcDir, destDir)
            except Exception as e:
                print(f"Error: {e}")
        elif choice == "2":
            srcDir = input("Source directory: ")
            archType = input("Archive type (zip or tar): ")
            try:
                archive_dir(srcDir, archType)
            except Exception as e:
                print(f"Error: {e}")
        elif choice == "3":
            zip_path = input("Zip file path: ")
            threshold_kb = float(input("Size threshold in KB: "))
            try:
                inspect_zip(zip_path, threshold_kb)
            except Exception as e:
                print(f"Error: {e}")
        elif choice == "4":
            directory = input("Directory path (blank for current): ") or os.getcwd()
            modified_last_month(directory)
        elif choice == "5":
            break
        else:
            print("Invalid option.")

if __name__ == "__main__":
    main_menu()
