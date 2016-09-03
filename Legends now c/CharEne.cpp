//Characters and enemies core classes
//I want this to more or less establish any NPC, Player character, and enemy types that the game needs.
#ifndef CHARACTER_H_
#define CHARACTER_H_
#include <string>
#include <iostream>
using namespace std;

class Character{
public:
	Character();
	//mutators
	void change_name(const string name);

private:
	string name = "";
};

class Player: public Character{
public:
	//constructor
	//Player();
	//mutators
	void level_up();
	

private:
	string name = "";
	int HP, ATK, DEF, SPD, LVL, exp;
	exp = 0
	HP = 100;
	ATK = 10;
	DEF = 10;
	SPD = 10;
	LVL = 1;
};

#endif