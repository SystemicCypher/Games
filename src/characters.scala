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
 *	All of these will be creatable and playable characters
 *	Additionally, there will be a few character classes:
 *	Fighter
 *	Mage(Red/White/Black)
 *	Thief
 * 	Ranger
 *	Martial Artist
 *	Paladin
 *
 *	And NPC-only classes:
 *	Shopkeeper, Trader, Soldier, Taxi, Librarian
 * 	Educators: Sage(mage), Grandmaster(fighter/martial artist), Dragoon(Paladin), Rogue(Thief)
 *	
 *	
 */

abstract class Character{
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

trait Playable{
	
	
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
	//ACTIONS////////////////////////////////////////
	// Required assignments - only when created
	override def assignStats(health: Int, strength: Int, dexterity:Int, constitution:Int, intelligence:Int, wisdom:Int, charisma:Int): Unit = {

	}
	override def assignGender(gender: Int): Unit = {
		gend = gender
	}
	override def assignName(newName: String): Unit = {
		name = newName
	}
	override def listStats(): List(Int) = {

	}



	override def hpAffected(fCalc: () => Int): Unit = {
		if(fCalc() == 0){
			println("It had no effect...")
		}
		else if(fCalc() < 0){
			
		}
		else{
			
		}
	}

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

//CLASSES~~~~~~~~~~~~~~~~~~~~~~~
/*
trait Fighter extends Character{
// Required stats assignment - only when created
	abstract override def assignStats(): Unit 

	abstract override def assignGender(): Unit
	
	abstract override def assignName(): Unit

// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit

// Level up check
	abstract override def levelUpCheck(): Boolean

// Status checks
	abstract override def isAlive(): Boolean

	abstract override def listStats(): List(Int)

// HP changes
	abstract override def hpAffected(fCalc: () => Int): Unit

// Healing operations
	abstract override def healCalc(): Int 

	// Combat system operations
	abstract override def damageCalc(): Int

	abstract override def dodge(): Boolean

	abstract override def attack(): Unit
	
	abstract override def useSpell(spell: Spell, target: Character): Unit ={

	}
}
*/

trait Mage extends Character{
}

trait BlackMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(lvl >= (spell.spellLevel * 5)){
			if(spell.spellType == SpellType.Black) {
				if(target.dodge){
					println("Missed!")
				}
				else{
					target.hpAffected(damageCalc)				
				}
			}	
			else{
				println("Black mages can only use black magic spells...")
			}
		}
		else{
			println("Level too low!")
		}
	}
}

trait RedMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(lvl >= (spell.spellLevel * 5) && spell.spellLevel < 6){
				if(target.dodge){
					println("Missed!")
				}
				else{
					target.hpAffected(damageCalc)				
				}
		}
		else{
			println("Level too low!")
		}
	}
}

trait WhiteMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(lvl >= (spell.spellLevel * 5)){
			if(spell.spellType == SpellType.White) {
					target.hpAffected(healCalc)				
			}	
			else{
				println("White mages can only use white magic spells...")
			}
		}
		else{
			println("Level too low!")
		}
	}
}

/*
trait Thief extends Character{
// Required stats assignment - only when created
	abstract override def assignStats(): Unit 

	abstract override def assignGender(): Unit
	
	abstract override def assignName(): Unit

// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit

// Level up check
	abstract override def levelUpCheck(): Boolean

// Status checks
	abstract override def isAlive(): Boolean

	abstract override def listStats(): List(Int)

// HP changes
	abstract override def hpAffected(fCalc: () => Int): Unit

// Healing operations
	abstract override def healCalc(): Int 

// Out of combat operations
	abstract override def speak(): String
	// Combat system operations
	abstract override def damageCalc(): Int

	abstract override def dodge(): Boolean

	abstract override def attack(): Unit
	
	abstract override def useSpell(spell: Spell): Unit 
}

trait Ranger extends Character{
// Required stats assignment - only when created
	abstract override def assignStats(): Unit 

	abstract override def assignGender(): Unit
	
	abstract override def assignName(): Unit

// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit

// Level up check
	abstract override def levelUpCheck(): Boolean

// Status checks
	abstract override def isAlive(): Boolean

	abstract override def listStats(): List(Int)

// HP changes
	abstract override def hpAffected(fCalc: () => Int): Unit

// Healing operations
	abstract override def healCalc(): Int 

// Out of combat operations
	abstract override def speak(): String
	// Combat system operations
	abstract override def damageCalc(): Int

	abstract override def dodge(): Boolean

	abstract override def attack(): Unit
	
	abstract override def useSpell(spell: Spell): Unit 
}

trait MartialArtist extends Character{
// Required stats assignment - only when created
	abstract override def assignStats(): Unit 

	abstract override def assignGender(): Unit
	
	abstract override def assignName(): Unit

// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit

// Level up check
	abstract override def levelUpCheck(): Boolean

// Status checks
	abstract override def isAlive(): Boolean

	abstract override def listStats(): List(Int)

// HP changes
	abstract override def hpAffected(fCalc: () => Int): Unit

// Healing operations
	abstract override def healCalc(): Int 

// Out of combat operations
	abstract override def speak(): String
	// Combat system operations
	abstract override def damageCalc(): Int

	abstract override def dodge(): Boolean

	abstract override def attack(): Unit
	
	abstract override def useSpell(spell: Spell): Unit 
}

trait Paladin extends Character{
// Required stats assignment - only when created
	abstract override def assignStats(): Unit 

	abstract override def assignGender(): Unit
	
	abstract override def assignName(): Unit

// Assign level-up stats
	abstract override def assignLvlUpStats(lvlUpchk: () => Boolean): Unit

// Level up check
	abstract override def levelUpCheck(): Boolean

// Status checks
	abstract override def isAlive(): Boolean

	abstract override def listStats(): List(Int)

// HP changes
	abstract override def hpAffected(fCalc: () => Int): Unit

// Healing operations
	abstract override def healCalc(): Int 

// Out of combat operations
	abstract override def speak(): String
	// Combat system operations
	abstract override def damageCalc(): Int

	abstract override def dodge(): Boolean

	abstract override def attack(): Unit
	
	abstract override def useSpell(spell: Spell): Unit 
}

*/