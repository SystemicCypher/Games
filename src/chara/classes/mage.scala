class Mage(char: Character) extends ClassDecorator(char){
	clas = "mage"
}

class BlkMage(char: Character) extends Mage(char){
	clas = "black" + super.clas
}
class WhtMage(char: Character) extends Mage(char){
	clas = "white" + super.clas
}
class RedMage(char: Character) extends Mage(char){
	clas = "red" + super.clas
}