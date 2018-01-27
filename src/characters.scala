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


//ACTIONS////////////////////////////////////////
// Required assignments - only when created
	def assignStats(): Unit
	def assignGender(): Unit
	def assignName(): Unit

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
	val hello = "Hello"
}
/*
trait NPC{

}
*/


//RACES~~~~~~~~~~~~~~~~~~~~~~


class Human extends Character{

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
// HP changes
	abstract override def hpAffected(fCalc: () => Int): Unit = {
		if(fCalc() == 0){

		}
		else if(fCalc() < 0){
			// damage resistance calculations
		}
		else{
			
		}
	}

// Healing operations
	abstract override def healCalc(): Int 

	// Combat system operations
	abstract override def damageCalc(): Int

	abstract override def dodge(): Boolean

	abstract override def attack(): Unit
	

}

trait BlackMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {

		
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
}

trait RedMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {
		if(spell.spellType == SpellType.Black) {
			if(target.dodge){
				println("Missed!")
			}
			else{
				target.hpAffected(damageCalc)				
			}
		}

		else if(spell.spellType == SpellType.Red){

		}
		else{
			
		}
	}
}

trait WhiteMage extends Mage{
	abstract override def useSpell(spell: Spell, target: Character): Unit = {

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