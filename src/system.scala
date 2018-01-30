/*
 *	The core of the rpg system, this file contains all the functions needed to operate the game.
 *	It also contains all possible game states - represented by a finite state machine.
 *	These are all essentially utility functions and are separate from the main class so they may be used and modified as needed
 *
*/

object RPGsystem{
//Utility functions

//Random Number Generator...or for this game RNGsus
	val rngsus = scala.util.Random
//Calculates the +1, +2, etc.. boosts for abilities from stats
	val abilityModifier = (abilityScore: Int) => ((abilityScore - 10) / 2)
	
//Calculate the amount of damage a character can do
	val damage = (attacker: Character) => (attacker.dex + attacker.str - 20)/2 + rngsus.nextInt(6)

//Actually uses the damage to some effect 
	def damageDeal(damage: Character => Int, target:Character, attacker: Character): Unit = {
		if(target.hp - damage(attacker) +  <= 0) {
			target.hp = 0 
			println(s"$target.name has died.")
		}
		else {
			target.hp = target.hp - damage(attacker)
			val damaged = damage(attacker)
			println(s"$target.name took $damaged points of damage!")
		}
	} 

//Calculate healing power
	val heal = (healer: Character) => (healer.intl + healer.wis - 20)/2 + rngsus.nextInt(6)

//Actually uses the healing amount to some effect
	def healDeal(heal: Character => Int, target: Character, healer: Character): Unit = {
		if(target.hp + heal(healer) >= target.maxHP) {
			target.hp = target.maxHP
			println(s"$target.name has been fully healed!")
		}
		else {
			target.hp = target.hp + heal(healer)
			val healed = heal(healer)
			println(s"$target.name gained $healed hp!")
		}
	}

//Experience to next level function
	val expToNextLevel = (char: Character) => char.lvl * 100 - char.exp

//Leveled up?
	def levelUp(char: Character, expNext: Character => Int): Unit = {
		if (expNext(char) <= 0){
			char.lvl += 1
			val remove = expNext(char)
			char.exp  = 0 - remove
		}
		else{
			val expNeeded = expNext(char)
			println(s"$char.name needs $expNeeded more experience to level up.")
		}
	}

//Learn a spell
	def addToSpellbook(char: Character, spell: Spell): Unit = {
		char.spellBook = char.spellBook + spell
	}







//The game finite state machine! That's all deliniated below 


//Character Creation
	def characterCreator(){

	}

//The main menu...pretty self-explanatory
	def mainMenu(): Unit = {

	}

//Run the game
	def run(): Unit = {
		mainMenu()
	}

}