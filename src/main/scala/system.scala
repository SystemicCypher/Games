/*
 *	The core of the rpg system, this file contains all the functions needed to operate the game.
 *	It also contains all possible game states - represented by a finite state machine.
 *	These are all essentially utility functions and are separate from the main class so they may be used and modified as needed
 *
*/
//import skill.spells._
import chara.Characterg
import chara.BaseCharacter
import chara.races._
import chara.classes._

object RPGsystem{
//Utility functions
	var playerCharacter: Characterg = new BaseCharacter()
	def acceptCharacter(char: Characterg): Unit = {
		playerCharacter = char
	}

//Random Number Generator...or for this game RNGsus
	val rngsus = scala.util.Random
//Calculates the +1, +2, etc.. boosts for abilities from stats
	val abilityModifier = (abilityScore: Int) => ((abilityScore - 10) / 2)
	
//Calculate the amount of damage a character can do
	val damage = (attacker: Characterg) => (attacker.dex + attacker.str - 20)/2 + rngsus.nextInt(6)

//Actually uses the damage to some effect 
	def damageDeal(damage: Characterg => Int, target:Characterg, attacker: Characterg): Unit = {
		if(target.hp - damage(attacker)  <=  0) {
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
	val heal = (healer: Characterg) => (healer.intl + healer.wis - 20)/2 + rngsus.nextInt(6)

//Actually uses the healing amount to some effect
	def healDeal(heal: Characterg => Int, target: Characterg, healer: Characterg): Unit = {
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
	val expToNextLevel = (char: Characterg) => char.lvl * 100 - char.exp

//Leveled up?
	def levelUp(char: Characterg, expNext: Characterg => Int): Unit = {
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
	//def addToSpellbook(char: Characterg, spell: Spell): Unit = {
	//	char.spellBook = char.spellBook + spell
	//}







//The game finite state machine! That's all deliniated below 
//Combat functions
	def playerTurn(){

	}
	def enemyTurn(){

	}




//Game
	def game(){
		println()

	}

//Character Creation
	def characterCreator1(): Unit ={
		println("Let's create your character.")
		println("Choose a race:")
		val raceChosen = readLine("1.Human  2.Elf  3.Dwarf  4.Orc  5.Hobbit\n")
		raceChosen match{
			case "1" => playerCharacter = new Human(playerCharacter)
			case "2" => playerCharacter = new Elf(playerCharacter)
			case "3" => playerCharacter = new Dwarf(playerCharacter)
			case "4" => playerCharacter = new Orc(playerCharacter)
			case "5" => playerCharacter = new Hobbit(playerCharacter)
			case unexpected => characterCreator1()
		}
		characterCreator2()

	}

	def characterCreator2(): Unit = {
		println("Choose a class:")
		val raceChosen = readLine("1.Fighter  2.Mage  3.Ranger 4.Paladin\n 5.Martial Artist 6.Thief\n")
		raceChosen match{
			case "1" => playerCharacter = new Fighter(playerCharacter)
			case "2" => playerCharacter = new Mage(playerCharacter)
			case "3" => playerCharacter = new Ranger(playerCharacter)
			case "4" => playerCharacter = new Paladin(playerCharacter)
			case "5" => playerCharacter = new MartialArtist(playerCharacter)
			case "6" => playerCharacter = new Thief(playerCharacter)
			case unexpected => characterCreator2()
		}
		if(raceChosen == 2) mageSpecific()
		game()
	}

	def mageSpecific(): Unit = {
		println("What kind of mage do you want to be?")
		val mageChoice = readLine("1.Black Mage  2.White Mage  3.Red Mage\n")
		mageChoice match{
			case "1" => playerCharacter = new BlkMage(playerCharacter)
			case "2" => playerCharacter = new WhtMage(playerCharacter)
			case "3" => playerCharacter = new RedMage(playerCharacter)
			case unexpected => mageSpecific()
		}
	}

//The main menu...pretty self-explanatory
	def mainMenu(): Unit = {
		println("Would you like to play the game or exit?")
		val choice = readLine("1. Play game      2.Exit\n")
		choice match{
			case "1" => characterCreator1()
			case "2" => println("Goodbye!")
			case unexpected => mainMenu()
		}
	}

//Run the game
	def run(): Unit = {
		mainMenu()
	}

}