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