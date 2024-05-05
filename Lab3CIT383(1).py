import os

#creates a number of files if they do not exists
def createFiles(fileNamePrefix:str, numOfFiles:int):
    for i in range(numOfFiles):
        filename = f"{fileNamePrefix}{i}.txt"
        if not os.path.exists(filename):
            open(filename, "w").close()

#returns the string File if it fileOrDirectoryPath is a file and Directory otherwise
def getType(fileOrDirectoryPath:str) -> str:
    if os.path.isfile(fileOrDirectoryPath):
        return "File"
    elif os.path.isdir(fileOrDirectoryPath):
        return "Directory"

#renames a file to the new name
def renameFile(filename:str, newName:str):
    if os.path.exists(filename):
        os.rename(filename, newName)

#renames a file to the new name
def createDir(nameOfDirectory:str):
    if not os.path.exists(nameOfDirectory):
        os.makedirs(nameOfDirectory)

#creates numberToCreate subdirectories of the directory directoryName
def createSubDirectories(directoryName:str, numberToCreate:int):
    for i in range(numberToCreate):
        subdir = os.path.join(directoryName, f"subdir{i}")
        os.makedirs(subdir, exist_ok=True)

#renames all the files in the target directory with extension currentExt to extension newExt.
def renameFiles(targetDirectory:str, currentExt:str, newExt:str):
    for filename in os.listdir(targetDirectory):
        if filename.endswith(currentExt):
            newName = filename.replace(currentExt, newExt)
            os.rename(os.path.join(targetDirectory, filename), os.path.join(targetDirectory, newName))

#displays the list of files and directories of the directory.
def displayContents(directoryName:str):
    print("Name", "Type", sep="\t")
    print("-------", "------", sep="\t")
    for name in os.listdir(directoryName):
        path = os.path.join(directoryName, name)
        print(name, getType(path), sep="\t")

def main():
    #Under your home directory, print the name of your current directory to the console
    print("Current Directory:", os.getcwd())
    
    #Under the home directory of the current user, create a directory labeled CITFall2023<username> where <username> is the username of the current Linux user.
    homeDir = os.path.expanduser("~")
    username = os.getlogin()
    directory = os.path.join(homeDir, f"CITFall2023{username}")
    createDir(directory)
    os.chdir(directory)
    #Print the name of the current directory to the console
    print("Current Directory:", os.getcwd())

    #Prompt the user for the number of files and their extension (a single extension for all the files), and call the appropriate method to create the files in the CITFall2023<username> directory created in step c above
    numOfFiles = int(input("Enter the number of files: "))
    fileExtension = input("Enter the file extension (txt, png, doc, dat): ")
    if fileExtension not in ["txt", "png", "doc", "dat"] or numOfFiles <= 0:
        print("Invalid input. Please input a number greater than zero or an extension (txt, png, doc, dat)")
        return
    createFiles("file", numOfFiles)

    # Prompt for number of subdirectories
    numOfSubDirs = int(input("Enter the number of subdirectories: "))
    if numOfSubDirs <= 0:
        print("Invalid input. The number of subdirectories cannot be 0 or negative.")
        return
    createSubDirectories(directory, numOfSubDirs)

    # Display contents of the current directory
    displayContents(directory)

    # Prompt for new extension for files
    newExtension = input("Enter the new extension for the files: ")
    if newExtension not in ["txt", "png", "doc", "dat"]:
        print("Invalid extension. Only txt, png, doc, and dat are allowed.")
        return
    renameFiles(directory, fileExtension, newExtension)

    # Display contents again
    displayContents(directory)

if __name__ == "__main__":
    main()