/*
 *	There will be a few character classes defined here:
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