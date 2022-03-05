#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

class BNFParser
{
private:
    static const int LANGUAGE_SIZE = 9;
    string const LANGUAGE[LANGUAGE_SIZE] = {
            "I = E",
            "P O P|P",
            "+|-|*|/|**",
            "I|L|UI|UL|(E)",
            "+|-|!",
            "CI|C",
            "a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z",
            "DL|D",
            "0|1|2|3|4|5|6|7|8|9"};
    char const LANGUAGE_KEYS[LANGUAGE_SIZE] = {
            'A', 'E', 'O', 'P', 'U', 'I', 'C', 'L', 'D'};
    vector<string> data;

public:
    void getDataFromFile(string filename)
    {
        ifstream input;
        string toParse;
        input.open(filename);
        if (!input)
        {
            cerr << "Error: file could not be opened" << endl;
            exit(1);
        }

        while (!input.eof())
        {

            input >> toParse;
            data.push_back(toParse);
        }
        input.close();
    }
    int getIndexByChar(char chr)
    {
        for (int i = 0; i < LANGUAGE_SIZE; i++)
        {
            if (chr == LANGUAGE_KEYS[i])
                return i;
        }
        return -1;
    }
    int parseLine(string line, int charIndex, int languageIndex)
    {
        int tempCharIndex = charIndex;
        for (int i = 0; i < LANGUAGE[languageIndex].length(); i++)
        {
            char currentChar = LANGUAGE[languageIndex][i];
            if (currentChar == '|')
            {
                if (tempCharIndex > -1)
                    return tempCharIndex;
                tempCharIndex = charIndex;
            }
            else if (tempCharIndex > -1 && currentChar != ' ')
            {
                int nextLanguageIndex = getIndexByChar(currentChar);
                if (nextLanguageIndex == -1)
                {
                    if (line[tempCharIndex] == currentChar){

                        tempCharIndex++;
                    }
                    else
                        tempCharIndex = -1;
                }
                else
                {
                    tempCharIndex = parseLine(line, tempCharIndex, nextLanguageIndex);
                }
            }
        }
        return tempCharIndex;
    }
    void parseData(){
        for (int i = 0; i < data.size(); i++)
        {
            int res = parseLine(data[i], 0, 0);
            if (res == data[i].length())
                cout << "The string '"+data[i]+"' is in the language." << endl;
            else
                cout  << "The string '"+data[i]+"' is not in the language." << endl;
        }


    }
};

int main()
{
    BNFParser bnf;
    bnf.getDataFromFile("input.txt");
    bnf.parseData();
    return 0;
}
