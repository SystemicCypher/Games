/*
The stats assignments and things will be done in the character creator. Too much is being handled by the core classes. I have split them up.
A separate combat mechanics system will be implemented, it's a function of the character's stats after all. 

*/
package chara

import scala.collection.mutable.ArrayBuffer
//import skill.spells.Spell

abstract class Characterg{
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

//Class and race checker
	var race:String 
	var clas:String

//Spellbook - contains spells for the characters
	//var spellBook = ArrayBuffer[Spell]()
}


class BaseCharacter extends Characterg{
//Values and Stats/////////////////////////////////
	override var name = ""
//	Hit Points
	override var hp = 10
	override var maxHP = 10

//	Stats     10 is average, one should be able to rearrange these
	override var str = 10
	override var dex = 10
	override var cons = 10
	override var intl = 10
	override var wis = 10
	override var cha = 10

//	Mana
	override var mana = 0 //established as a function of int and wis

//	Level and experience points
	override var lvl = 1
	override var exp = 0

//Class and race checker
	override var race = ""
	override var clas = ""

}

abstract class CharacterDecorator(char: Characterg) extends Characterg{
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

