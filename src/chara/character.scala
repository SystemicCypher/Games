/*
The stats assignments and things will be done in the character creator. Too much is being handled by the core classes. I have split them up.
A separate combat mechanics system will be implemented, it's a function of the character's stats after all. 

*/

class Character{
//Values and Stats/////////////////////////////////
	var name: String
//	Hit Points
	var hp: Int = 10
	var maxHP: Int  = 10

//	Stats     10 is average, one should be able to rearrange these
	var str: Int = 10
	var dex: Int = 10
	var cons: Int = 10
	var intl: Int = 10
	var wis: Int = 10
	var cha: Int = 10

//	Mana
	var mana: Int = 5

//	Level and experience points
	var lvl: Int = 1
	var exp: Int = 0
	var expToNext: Int = 100

	var charClass: Clas
	var charRace: Race

}

