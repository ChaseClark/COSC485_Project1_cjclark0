# COSC485_Project1_cjclark0
 Deterministic Finite Automata Simulator made in Java


## Planning

Input file for DFA looks like:
```

M = { States, Alphabet, Transition Function, Starting State, Final States }

where, 

States = { q0, q1, q2, q3, q4 }, 

Alphabet = { a, b }, 

Starting State = q0, 

Final States = { q1, q3 },

Transition Function = {
	( q0, a, q4 ), 
	( q0, b, q1 ),
	( q1, a, q2 ),
	( q1, b, q2 ),
	( q2, a, q2 ), 
	( q2, b, q2 ),
	( q3, a, q2 ),
	( q3, b, q2 ),
	( q4, a, q4 ),
	( q4, b, q3 )
}

```
Input for the strings is like:
```
b
ab
aab
aaab
aaaab

aaaaab
aaaaaaaa
aaaaaaab
bbbbbbbbbb
```

And the output should be:
```
b is accepted.
ab is accepted.
aab is accepted.
aaab is accepted.
aaaab is accepted.
 is rejected.
aaaaab is accepted.
aaaaaaaa is rejected.
aaaaaaab is accepted.
bbbbbbbbbb is rejected.
```

## Questions

1. How to read the input file to collect the information of DFA including the States, Alphabet, Starting State, Final States, and Transition Function based on the file structure?


2. What kind of data structure can be used to store them?
ArrayLists


3. How to run the DFA to decide whether to accept or reject a string?

## Answers

3. Use a foreach loop to loop over the input strings.