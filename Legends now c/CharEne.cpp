//Characters and enemies core classes
//I want this to more or less establish any NPC, Player character, and enemy types that the game needs.
#ifndef CHARACTER_H_
#define CHARACTER_H_
#include <string>
#include <iostream>

class Character{
public:
	Character();
private:
	string name = "";
	int HP, ATK, DEF, SPD, LVL;
	HP = 100;
	ATK = 10;
	DEF = 10;
	SPD = 10;
	LVL = 1;
};

class Player{
public:
	//constructor
	Player();
	//mutators


private:
	string name = "";
	int HP, ATK, DEF, SPD, LVL;
	HP = 100;
	ATK = 10;
	DEF = 10;
	SPD = 10;
	LVL = 1;
};

#endif