/**
   Name: Hamad Nasir
   Roll No. : 120312
   Section: BSCS-6C
   Course: Advanced Programming
   Assignment No:1

**/

#include <iostream> 
#include <fstream>
#include <string>
#include <cstdio>
using namespace std;
//function identifiers
void writing();
void display();
void deleting();
void delete_line(const char *file_name, int n);

//student class
class student {
//public variables
public:
	string Name;
	string Class;
	string Month;
	int Registration;
	int Fee;
};

int main()
{
	int opt=0;
	cout << "***** Welcome to Student Management System *****\n";
	while (opt!=4) {
		cout << "\nEnter an option number to continue:";
		cout << "\nEnter 1 to Add:";
		cout << "\nEnter 2 to Delete:";
		cout << "\nPress 3 to Display:";
		cout << "\nPress 4 to Exit:";
		cout << "\nEnter an option number: ";
		cin >> opt;
		if (cin.fail()) {
			cin.clear();
			cin.ignore();
			cout << "Invalid Input" << endl;
		}
		switch (opt)
		{
		case 1:
		{
			writing();
			break;
		}

		case 2:
		{
			deleting();
			break;
		}

		case 3:
		{
			display();
			break;
		}
	  }
	}
}
//function for adding student
void writing()
{
	//student object
	student studentObj;
	cout << "Enter Name of student: ";
	cin >> studentObj.Name;
	cout << "Enter Class of student: ";
	cin >> studentObj.Class;
	cout << "Enter Month of student: ";
	cin >> studentObj.Month;
	cout << "Enter Registration of student: ";
	cin >> studentObj.Registration;
	cout << "Enter Fee of student: ";
	cin >> studentObj.Fee;
	
	ofstream myfile;
	//creating,opening and storing attributes in the file
	myfile.open("studentDatabase.txt", ios::app | ios::out);
	myfile << endl<< "{RegistrationNo=" << "[" << studentObj.Registration << "];";
	myfile << "Name=" << "[" << studentObj.Name << "];";
	myfile << "Class=" << "[" << studentObj.Class << "];";
	myfile << "Month=" << "[" << studentObj.Month << "];";
	myfile <<"Fee="<<"[Rs-"<< studentObj.Fee<<"];}" << endl;
	//closing the file
	myfile.close(); 

	cout << "The student has been successfully added! \n";
}


//function for deleting the student
void deleting()
{
	ifstream myfile;
	//generating a temporary file
	ofstream temp;
	myfile.open("studentDatabase.txt");
	temp.open("temp.txt");
	string line, search;
	cout << "Enter the registration no. of student whose record you want to delete: \n";
	cin >> search;

	for (unsigned int curLine = 0; getline(myfile, line); curLine++)
	{
		if (line.find(search) != string::npos)  //
		{
			//getting the line number of the student to be deleted
			cout << "Found Student with Registration No. " << search << " on line: " << curLine << endl;
			cout << "The student has been successfully deleted! \n";

			//passing the line number of the student and the target file to this function which actually deletes that one line
			delete_line("studentDatabase.txt", curLine + 1);
			//closing both files
			temp.close();
			myfile.close();
			//renaming the new file as actuall file and deleting the previous file
			remove("studentDatabase.txt");
			rename("temp.txt", "studentDatabase.txt");
		}
	}
	
}
//function for displaying all the students stored
void display()
{
	string getcontent;
	ifstream openfile("studentDatabase.txt");
	if (openfile.is_open())
	{
		while (!openfile.eof())
		{
			getline(openfile, getcontent);
			cout << getcontent << endl;
		}
		cout << "All the students records have been successfully displayed! \n";
	}
}

//function which actually deletes the student after getting its line number in the file
void delete_line(const char *file_name, int n)
{
	// open file in read mode or in mode 
	ifstream is(file_name);

	// open file in write mode or out mode 
	ofstream ofs;
	ofs.open("temp.txt", ofstream::out);

	// loop getting single characters 
	char c;
	int line_no = 1;
	while (is.get(c))
	{
		// if a newline character 
		if (c == '\n')
			line_no++;

		// file content not to be deleted 
		if (line_no != n)
			ofs << c;
	}

	// closing output file 
	ofs.close();

	// closing input file 
	is.close();

	// remove the original file 
	remove(file_name);

	// rename the file 
	rename("temp.txt", file_name);
}