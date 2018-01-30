/*
The stats assignments and things will be done in the character creator. Too much is being handled by the core classes. I have split them up.
A separate combat mechanics system will be implemented, it's a function of the character's stats after all. 

*/
import scala.collection.mutable.ArrayBuffer

trait Character{
//Values and Stats/////////////////////////////////
	var name: String
//	Hit Points
	var hp: Int
	var maxHP: Int

//	Stats     10 is average, one should be able to rearrange these
	var str: Int 
	var dex: Int 
	var cons: Int
	var intl: Int
	var wis: Int
	var cha: Int

//	Mana
	var mana: Int //established as a function of int and wis

//	Level and experience points
	var lvl: Int
	var exp: Int
	var expToNext: Int 

//Class and race checker
	var race:String 
	var clas:String

//Spellbook - contains spells for the characters
	var spellBook = ArrayBuffer[Spell]()
}


class BaseCharacter extends Character{
//Values and Stats/////////////////////////////////
	name = ""
//	Hit Points
	hp = 10
	maxHP = 10

//	Stats     10 is average, one should be able to rearrange these
	str = 10
	dex = 10
	cons = 10
	intl = 10
	wis = 10
	cha = 10

//	Mana
	mana = 0 //established as a function of int and wis

//	Level and experience points
	lvl = 1
	exp = 0

//Class and race checker
	race = ""
	clas = ""

}

abstract class CharacterDecorator(char: Character) extends Character{
	//Values and Stats/////////////////////////////////
	name = char.name
//	Hit Points
	hp = char.hp
	maxHP = char.maxHP

//	Stats     10 is average, one should be able to rearrange these
	str = char.str
	dex = char.dex
	cons = char.cons
	intl = char.intl
	wis = char.wis
	cha = char.cha

//	Mana
	mana = char.mana //established as a function of int and wis

//	Level and experience points
	lvl = char.lvl
	exp = char.exp

//Class and race checker
	race = char.race
	clas = char.clas
}

