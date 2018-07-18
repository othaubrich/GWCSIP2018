import random

def main():
    welcome = ('Welcome to Hangman! A word will be chosen at random and you must try to guess the word correctly letter by letter before you run out of attempts. Good luck!')
    print(welcome)
main()

def game():
    words = ("mattress", "yacht", "africa", "shampoo", "banjo",  "oxygen", "letter", "salmon")
    word = random.choice(words)
    word = word.lower()
    guesses = []
    wrong = []
    tries = 10

    while tries > 0:

        out = ""
        for letter in word:
            if letter in guesses:
                out = out + letter
            else:
                out = out + "_"

        if out == word:
            break
        print("Guess the word:", out)
        print(tries, "chances left")

        guess = input()

        if guess in guesses or guess in wrong:
            print("Already guessed", guess)
        elif guess in word:
            print("Yay")
            guesses.append(guess)
        else:
            print("Nope")
            tries = tries - 1
            wrong.append(guess)

        print()
    if tries:
            print("You guessed", word)
    else:
        print("You didn't get", word)
    #guess = input("Guess a letter: ")
    #ask = "Guess a letter"
    #for i in range (0,10):
        #if guess in word:
            #print("Good")
            #print(guess)
        #elif guess not in word:
        #    print("try again")
        #    print(guess)
    #blank = ('_')
    #i = guesses
game()








    #words = ["hangman", "index", "letter", "word", "wax",
            #"medication", "operation", "program", "oxygen", "pajama",
            #"africa", "mattress", "hyphen", "bagpipes", "window",
            #"bacteria", "yacht", "mosquito", "mango", "shampoo"]
