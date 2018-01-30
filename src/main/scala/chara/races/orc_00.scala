package chara.races
import chara._ 
class Orc(char: Characterg) extends RaceDecorator(char){
	str = super.str + 4 
	dex = super.dex + 0
	cons = super.cons + 0
	intl = super.intl + 0
	wis = super.wis + 0
	cha = super.cha + 0
	race = "orc"
}