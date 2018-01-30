package chara.races

class Human(char: Character) extends RaceDecorator(char){
	str = super.str + 0 
	dex = super.dex + 2
	cons = super.cons + 2
	intl = super.intl + 0
	wis = super.wis + 0
	cha = super.cha + 0
	race = "human"


}