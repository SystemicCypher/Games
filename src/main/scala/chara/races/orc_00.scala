package chara.races
import chara._ 
class Orc(char: Characterg) extends RaceDecorator(char){
	override var str = char.str + 4 
	override var dex = char.dex + 0
	override var cons = char.cons + 0
	override var intl = char.intl + 0
	override var wis = char.wis + 0
	override var cha = char.cha + 0
	override var race = "orc"

	override var name = char.name
	override var clas = char.clas
	override var exp = char.exp
	override var mana = char.mana
	override var lvl = char.lvl
	override var hp = char.hp
	override var maxHP = char.maxHP
}