endings_unlocked = {}
print("Welcome to Choose Your Own Disaster V 0.1 a! Or CYOD! Good luck....you're gonna need it....")
ans = input("You are walking home from a party, you notice there is a small, red box on the street to your left... Do you (1) pick it up? or (2) leave it alone?")
if ans == "1":
    print("You have picked up the box. It doesn't seem like anything special. You throw it in your backpack")
    inventory = ["little red box"]
    print("You have: " + str(inventory) + " in your inventory")
    ans = input("You continue walking....After a few steps the earth begins to shake and you see a flying saucer descend...Do you (1) run for it? or (2) Stay and watch?")
    if ans == "1":
        print("You got the f**k out of there....Buuuut the aliens are in a flying saucer you idiot. They caught you and took you into their spaceship.")
        ans= input("You are strapped up to an examination desk and probed. The aliens ask you if you want to learn the secrets of the universe. Do you say (1) 'I know them all!!' It's 42! (2) 'Sure' (3) Don't respond.")
        if ans == "1":
            print("The aliens are amazed and you become their god. They sacrifice you to a higher deity... OK END 01")
        elif ans == '2':
            print("They plug you into the Matrix(TM) and you run into Morpheus and Agent Smith. You are 'the One'. You are only there for a little while as your brain is loaded with tons of knowledge.")
            ans = input("Once they unplug you you know the deepest secrets of the universe. Do you (1) Try to break out or (2) obey their every command?")
            if ans == "1":
                print("The aliens activated their killswitch on you and you died. DEAD END 02")
    elif ans == "2":
        print("You watch as the aliens descend and approach you. They tell you to take out the red box. You do so. You find a button on the box.")
        ans = input("Do you push the button on the box (1) or hand it back(2)? ")
        if ans == "1":
            print("You are teleported to your home....Turns out it was a dream. You realize today is the day you were going to visit one of your friends.")
            ans = input("You are on your way to your friend's house. Do you (1) go back home? or (2) go to your friend's house?")
            if ans == "1":
                print("You go to your basement and find a time machine, do you: (1) Use the time machine? or (2) Go back to your friend's house?")
                if ans == "1":
                    print("You are transported to Mars")
        elif ans == "2":
            print("You give back the box. The aliens have found humans are very compliant to subconcious telepathic manipulation and would make an excellent slave race.")
            print("GLOBAL SLAVERY END 03")
elif ans == "2":
    print("You ignored the box like an idiot and now you aren't going to have an amazing adventure in space with aliens. Wow you're boring....")
    print("BORING END 00")
elif ans == "end":
    for item in endings:
        pass
else:
    print("Not a valid answer....")
    print("NO ANSWER END -01")


