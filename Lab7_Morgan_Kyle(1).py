#!/usr/bin/python
import os
import sys
import argparse as ap
# Specifies Directory Contents
def dirContents(path, only_dirs=False, logfile=None):
   
    if not os.path.exists(path):
        message = f"Error: The directory '{path}' does not exist."
        if logfile:
            with open(logfile, 'w') as log:
                log.write(message + "\n")
        else:
            print(message)
        sys.exit(1)

    entries = os.listdir(path)
    entries = [e for e in entries if not e.startswith('.')] 
    if only_dirs:
        entries = [e for e in entries if os.path.isdir(os.path.join(path, e))]
    #Sets header for output
    output = ["File/Dir # Name", "******** ************************"]
    for i, entry in enumerate(entries, start=1):
        output.append(f"{i}    {entry}")

    output_str = "\n".join(output)
    if logfile:
        with open(logfile, 'w') as log:
            log.write(output_str + "\n")
    else:
        print(output_str)

def main():
    parser = ap.ArgumentParser(description='List the contents of a directory.')
    parser.add_argument('-i', '--logfile', type=str, help='Output semt to the log file with the specified name.')
    parser.add_argument('-d', '--dir', action='store_true', help='List only the directories in the specified location.')
    parser.add_argument('DIR_PATH', type=str, help='Path of the directory from which the files need to be listed.')
    args = parser.parse_args()

    dirContents(args.DIR_PATH, only_dirs=args.dir, logfile=args.logfile)

if __name__ == "__main__":
    main()
