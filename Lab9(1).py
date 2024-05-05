#!/usr/bin/python
import argparse
from ftplib import FTP
#Upload from current directory
def upload_file(ftp, filename, target_dir):
    try:
        with open(filename, 'rb') as file:
            ftp.storbinary(f'STOR {target_dir}/{filename}', file)
            print(f"Uploaded {filename} to FTP server.")
    except FileNotFoundError:
        print("Error: File does not exist.")
    except Exception as e:
        print(f"An error occurred during upload: {e}")
#Download file extension
def download_file(ftp, extension, target_dir):
    
    try:
        ftp.cwd(target_dir)
        files = ftp.nlst()
        found = False
        for file in files:
            if file.endswith(extension):
                with open(file, 'wb') as local_file:
                    ftp.retrbinary(f'RETR {file}', local_file.write)
                print(f"Downloaded {file} from FTP server.")
                found = True
        if not found:
            print(f"No files with extension '{extension}' found on the server.")
    except Exception as e:
        print(f"An error occurred during download: {e}")
# Execute ls
def exec_command(ftp, file_type, target_dir):
    try:
        ftp.cwd(target_dir)
        files = ftp.nlst()
        filtered_files = [file for file in files if file.endswith(file_type)]
        if filtered_files:
            print("Listing files:")
            for file in filtered_files:
                print(file)
        else:
            print(f"No files with extension '{file_type}' found.")
    except Exception as e:
        print(f"An error occurred during file listing: {e}")

def main():
    parser = argparse.ArgumentParser(description="FTP File Management Script")
    parser.add_argument("ftp_server_ip", help="IP address of the FTP server.")
    parser.add_argument("-u", "--upload", help="Upload a file to the FTP server. Specify the filename.")
    parser.add_argument("-d", "--download", help="Download files with a specific extension from the FTP server.")
    parser.add_argument("-l", "--list", help="List files of a specific type in the directory.")

    args = parser.parse_args()

    # Establish FTP connection
    ftp = FTP(args.ftp_server_ip)
    ftp.login()  
    ftp.cwd('cit383F2023')  

    if args.upload:
        upload_file(ftp, args.upload, 'cit383F2023')
    if args.download:
        download_file(ftp, args.download, 'cit383F2023')
    if args.list:
        exec_command(ftp, args.list, 'cit383F2023')

    ftp.quit()
    print("Program execution completed successfully.")

if __name__ == '__main__':
    main()
