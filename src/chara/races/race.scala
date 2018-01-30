abstract class RaceDecorator(char: Character) extends CharacterDecorator(char){
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