package chara.classes
import chara._ 
class Thief(char: Characterg) extends ClassDecorator(char){
	override var str = char.str  
	override var dex = char.dex 
	override var cons = char.cons 
	override var intl = char.intl 
	override var wis = char.wis 
	override var cha = char.cha 
	override var race = char.race

	override var name = char.name
	override var clas = "thief"
	override var exp = char.exp
	override var mana = char.mana
	override var lvl = char.lvl
	override var hp = char.hp
	override var maxHP = char.maxHP
}