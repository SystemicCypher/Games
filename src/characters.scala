/*
 *	This file defines classes that control the character system.
 *	There will be several different races with their corresponding stats: 
 *	Human - x
 *	Elf - x
 *	Orc - x
 *	Dwarf - x 
 *	Dragon -
 *	Troll - 
 *	Hobbit - x
 *	Demon -
 *	Goblin -
 *	etc... (maybe more to be added later) [All x-ed races have been implemented, others will be soon]
*/

class Character{
//Values and Stats/////////////////////////////////
	protected var name: String
//	Hit Points
	protected var hp: Int
	protected var maxHP: Int 

//	Stats
	protected var str: Int
	protected var dex: Int
	protected var cons: Int
	protected var intl: Int
	protected var wis: Int
	protected var cha: Int

//	Mana
	protected var mana: Int

// Gender
	protected var gend: Int

//	Level and experience points
	protected var lvl: Int
	protected var exp: Int
	protected var expToNext: Int


//ACTIONS////////////////////////////////////////
// Required assignments - only when created
	def assignStats(health: Int, strength: Int, dexterity:Int, constitution:Int, intelligence:Int, wisdom:Int, charisma:Int): Unit
	def assignGender(gender: Int): Unit
	def assignName(newName: String): Unit

// Assign level-up stats
	def assignLvlUpStats(lvlUpchk: () => Boolean): Unit

// Level up check
	def levelUpCheck(): Boolean

// Status checks
	def isAlive(): Boolean
	def listStats(): List(Int)

// HP changes
	def hpAffected(fCalc: () => Int): Unit

// Combat system operations
	def damageCalc(): Int 
	def dodge(): Boolean
	def attack(): Unit
	def useSpell(spell: Spell, target: Character): Unit 

// Healing operations
	def healCalc(): Int 

}

//GAME DETAILS~~~~~~~~~~~~~~~

class BaseCharacter extends Character{
	override def assignStats(health: Int, strength: Int, dexterity:Int, constitution:Int, intelligence:Int, wisdom:Int, charisma:Int): Unit = {
		maxHP = health
		str = strength
		dex = dexterity
		cons = constitution
		intl = intelligence
		wis = wisdom
		cha = charisma

		lvl = 1
		exp = 0

	}

	override def assignGender(gender: Int): Unit = {
		gend = gender
	}

	override def assignName(newName: String): Unit = {
		name = newName
	}

	override def listStats(): List(Int) = {
		List(hp, str, dex, cons, intl, wis, cha, lvl, exp, expToNext)
	}



	override def hpAffected(fCalc: () => Int): Unit = {
		if(fCalc() == 0){
			println("It had no effect...")
		}
		else if(fCalc() < 0){
			val damageModifier = cons/5
		}
		else{
			
		}
	}
	
}

abstract class CharacterDecorator(decoratedCharacter: Character) extends Character{
	maxHP = decoratedCharacter.maxHP
	cha = decoratedCharacter.cha
	str = decoratedCharacter.str
	intl = decoratedCharacter.intl
	dex = decoratedCharacter.dex
	cons = decoratedCharacter.cons
	wis = decoratedCharacter.wis




}







trait NPC extends Character{
	// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit = {

	}

	// Level up check
	 abstract override def levelUpCheck(): Boolean = {

	}
}


//Level difficulties
trait EasyLevel extends Character{
	// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit = {

	}

	// Level up check
	 abstract override def levelUpCheck(): Boolean = {

	}
}

//Zombie or not?
trait Living extends Character{
	// Status checks
	override def isAlive(): Boolean = {
		hp > 0
	}
}

trait Undead extends Character{
	// Status checks
	override def isAlive(): Boolean = {
		hp <= 0
	}
}


//RACES~~~~~~~~~~~~~~~~~~~~~~


class Human extends Character{

	

	// Combat system operations
	override def damageCalc(): Int = {

	} 
	override def dodge(): Boolean = {

	}
	override def attack(): Unit = {

	}

	// Healing operations
	override def healCalc(): Int = {

	}

}
/*
class Elf extends Character{

}

class Orc extends Character {

}

class Dwarf extends Character{

}

class Hobbit extends Character{
}
*/

