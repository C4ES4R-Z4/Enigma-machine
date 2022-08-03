# Enigma-machine

This is a project I started in 2017 (during my gap year before university).
I only had basic math skills, my Java was good, but nowhere near great or even on industry level.
Please don't judge 2017-me for my code qualiy - thanks.

## What is this?

This is an _ ahem _ `Enigma Machine Emulator` which I thought was a cool thing to code, but I got bored halfway through and never built a decryption function.
Oh well, I'll just go knock on Turing's door for some help with that part later.

## How to use?

Well, I kinda... forgot? There's a config file (Saved.cfg) for the rotors or something. Idk

To compile:

```cd enigma-machine
javac Enigma.java
```

To run (after you compiled duh):

```cd enigma-machine
java Enigma < plaintext.in
```

The `plaintext.in` file is just a text file containing the... plaintext.
The cyphertext should be printed on your screen now.

## Tests

Running a stupid little test file for the default config.

```
cd engima-machine
python3 tests.py
```
