# Wordle Clone

A simple, command-line implementation of the popular Wordle game. This project replicates the core functionality of Wordle, allowing users to guess a hidden word within a limited number of attempts.

## Features

- **Ternary Search Trie**: Trie based on Princeton's Robert Sedgewick and Kevin Wayne's (Algorithms II ) implementation. The TST validates word (is it in the english lexicon) before validation of
- character positions.
- **Interactive Gameplay**: Players can input guesses and receive feedback on letter positions.
- **Customizable Word List**: Easily update the game with your own word bank.
- **Cross-Platform Compatibility**: Runs on any system with a Java Runtime Environment (JRE).
- **Scalable Difficulty**: Configure word length and maximum number of guesses.
