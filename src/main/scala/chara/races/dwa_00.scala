package chara.races
import chara._ 
class Dwarf(char: Characterg) extends RaceDecorator(char){
	str = super.str + 0 
	dex = super.dex + 0
	cons = super.cons + 4
	intl = super.intl + 0
	wis = super.wis + 0
	cha = super.cha + 0
	race = "dwarf"
}