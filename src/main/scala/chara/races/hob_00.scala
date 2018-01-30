package chara.races
import chara._ 

class Hobbit(char: Characterg) extends RaceDecorator(char){
	str = super.str + 0 
	dex = super.dex + 2
	cons = super.cons + 0
	intl = super.intl + 2
	wis = super.wis + 0
	cha = super.cha + 0
	race = "hobbit"
}