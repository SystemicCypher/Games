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
	var enemyCharacter: Characterg = new BaseCharacter()

	def acceptCharacter(char: Characterg): Unit = {
		playerCharacter = char
	}

	var loopCounter = 0; //temporary thing


//Random Number Generator...or for this game RNGsus
	val rngsus = scala.util.Random
//Calculates the +1, +2, etc.. boosts for abilities from stats
	val abilityModifier = (abilityScore: Int) => ((abilityScore - 10) / 2)
	
//Calculate the amount of damage a character can do
	val damage = (attacker: Characterg) => (attacker.dex + attacker.str - 20)/2 + rngsus.nextInt(6)

//Actually uses the damage to some effect 
	def damageDeal(damage: Characterg => Int, target:Characterg, attacker: Characterg): Unit = {
		val damaged = damage(attacker)
		if(target.hp - damaged  <=  0) {
			target.hp = 0 
			print(target.name)
			println(" has died.")
		}
		else {
			target.hp -= damaged
			print(target.name)
			print(" took ")
			print(damaged)
			println(" points of damage!")
		}
	} 

//Calculate healing power
	val heal = (healer: Characterg) => (healer.intl + healer.wis - 20)/2 + rngsus.nextInt(6)

//Actually uses the healing amount to some effect
	def healDeal(heal: Characterg => Int, target: Characterg, healer: Characterg): Unit = {
		val healed = heal(healer)
		if(target.hp + healed >= target.maxHP) {
			target.hp = target.maxHP
			print(target.name)
			println(" has been fully healed!")
		}
		else {
			target.hp += healed
			print(target.name)
			print(" gained ")
			print(healed)
			println(" hp!")
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
			boostSkill(char)
		}
		else{
			val expNeeded = expNext(char)
			print(char.name)
			print(" needs ")
			print(expNeeded)
			println(" experience to level up.")
		}
	}

//Gain 1 skill point
	def boostSkill(char: Characterg): Unit = {
		print(char.name)
		println("'s stats:\n")
		print("1.Str: ")
		println(char.str)
		print("2.Dex: ")
		println(char.dex)
		print("3.Int: ")
		println(char.intl)
		print("4.Wis: ")
		println(char.wis)
		print("5.Cha: ")
		println(char.cha)
		print("6.Cons: ")
		println(char.cons)
		val boosted = readLine("Choose skill to boost: \n")


		boosted match{
			case "1" => char.str += 1
			case "2" => char.dex += 1
			case "3" => char.intl += 1
			case "4" => char.wis += 1
			case "5" => char.cha += 1
			case "6" => char.cons += 1
			case unexpected => characterCreator2()
		}
	}


//Learn a spell
	//def addToSpellbook(char: Characterg, spell: Spell): Unit = {
	//	char.spellBook = char.spellBook + spell
	//}


	def outOfCombat(){
		val choice = readLine("1.Heal    2.Shop  3.Check Inventory   4.Continue\n")
		if(choice == "1"){
			healDeal(heal, playerCharacter, playerCharacter)
			outOfCombat()
		}
		else if(choice == "2"){
			println("No shop")
			outOfCombat()
		}
		else if(choice == "3"){
			println("No Inventory")
			outOfCombat()
		}
		else if(choice == "4"){
			println("Onward...")
		}
		else{
			println("Invalid choice...")
			outOfCombat()
		}
	}




//The game finite state machine! That's all deliniated below 
//Combat functions
	def playerTurn():Unit = {
		val combatChoice = readLine("1.Attack    2.Spell   3.Check Stats   4.Flee\n")
		if(combatChoice == "1"){
			damageDeal(damage, enemyCharacter, playerCharacter)
			enemyTurn()
		}
		else if(combatChoice == "2"){
			println("No spells yet!")
			playerTurn()
		}
		else if(combatChoice == "3"){
			print(playerCharacter.name)
			print(" has ")
			print(playerCharacter.hp)
			println("hp.")
			print(enemyCharacter.name)
			print(" has ")
			print(enemyCharacter.hp)
			println("hp.")
			playerTurn()
		}
		else if(combatChoice == "4"){
			val escaping = flee()
			if(escaping) game()
			else enemyTurn()
		}
		else if(combatChoice == "5"){
			healDeal(heal, playerCharacter, playerCharacter)
			enemyTurn()
		}
		else{
			println("Invalid choice...")
			playerTurn()
		}
	}

	def enemyTurn():Unit ={
		val miss = rngsus.nextInt(9)
		if(enemyCharacter.hp > 0 && miss < 7){
			damageDeal(damage, playerCharacter, enemyCharacter)
		}
		combat()
	}

	def combat(): Unit = {
		if(playerCharacter.hp == 0 || enemyCharacter.hp == 0){
			enemyCharacter = new BaseCharacter()
			if(playerCharacter.hp == 0){
				loopCounter = 15
				game()
			}
			else{
				println("You defeated the enemy!")
				playerCharacter.exp += 100
				levelUp(playerCharacter, expToNextLevel)
				game()
			}
		}
		else{
			playerTurn()
		}
	}

	def flee(): Boolean = {
		val escape = rngsus.nextInt(100)
		if(escape > 85){
			println("Escape failed...")
			false
		}
		else{
			println("Escaped!")
			true
		}
	}

	def enemyCreation(): Unit ={
		var rando = rngsus.nextInt(100)
		if(rando >= 0 && rando < 20){
			enemyCharacter = new Elf(enemyCharacter)
			enemyCharacter = new Fighter(enemyCharacter)
			enemyCharacter.name = "Enemy elf"
		}
		else{
			enemyCharacter = new Orc(enemyCharacter)
			enemyCharacter = new Fighter(enemyCharacter)
			enemyCharacter.name = "Enemy orc"
		}
	}



//Game
	def game(): Unit = {
		var random = rngsus.nextInt(100)
		
		if(loopCounter == 15) print("")
		else if(random <= 20){
			println("You explore...")
			outOfCombat()
			loopCounter += 1
			game()
		}
		else{
			println("You explore...")
			outOfCombat()
			loopCounter += 1
			println("An enemy strikes!")
			enemyCreation()
			combat()
			game()
		}

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
		val raceChosen = readLine("1.Fighter  2.Mage  3.Ranger 4.Paladin 5.Martial Artist 6.Thief\n")
		raceChosen match{
			case "1" => playerCharacter = new Fighter(playerCharacter)
			case "2" => playerCharacter = new Mage(playerCharacter)
			case "3" => playerCharacter = new Ranger(playerCharacter)
			case "4" => playerCharacter = new Paladin(playerCharacter)
			case "5" => playerCharacter = new MartialArtist(playerCharacter)
			case "6" => playerCharacter = new Thief(playerCharacter)
			case unexpected => characterCreator2()
		}
		if(raceChosen == "2") mageSpecific()
		val nameChosen = readLine("What will your name be?\n")
		playerCharacter.name = nameChosen
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
		val choice = readLine("1.Fighting Mode   2.Adventure Mode   3.Exit\n")
		choice match{
			case "1" => characterCreator1()
			case "2" => println("Adventure Mode not yet implemented!")
			case "3" => println("Goodbye!")
			case unexpected => mainMenu()
		}
	}

//Run the game
	def run(): Unit = {
		mainMenu()
	}

}