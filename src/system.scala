/*
 *	The core of the rpg system, this file contains all the functions needed to operate the game.
 *	It also contains all possible game states - represented by a finite state machine.
 *	
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