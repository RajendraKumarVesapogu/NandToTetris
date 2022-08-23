(KEYBOARD)
@16384
D=A
@0
M=D  // storing first column value in RAM[0]
@16385
D=A
@1
M=D  // storing second column value in RAM[1]
@16386
D=A
@2
M=D  // storing second column value in RAM[2]
@16387
D=A
@3
M=D  // storing second column value in RAM[3]
@16398
D=A
@4
M=D  // storing fourth column value in RAM[4]
@16399
D=A
@5
M=D  // storing third column value in RAM[5]
@16400
D=A
@6
M=D  // storing fourth column value in RAM[6]
@16401
D=A
@7
M=D  // storing fourth column value in RAM[7]
@16412
D=A
@8
M=D  // storing fifth column value in RAM[8]
@16413
D=A
@9
M=D  // storing fifth column value in RAM[9]
@16414
D=A
@10
M=D  // storing fifth column value in RAM[10]
@16415
D=A
@11
M=D  // storing sixth  column value in RAM[11]
@curr  // restting the value
M=0
@j
M=-1 // variable which decides the register is black or white
@72// value of H
D=A
@KBD // keyboard
D=D-M
@LOOP // for pattern
D;JEQ
@j // j will be 0 if above condition is false, i.e. KEYBOARD != 72
M=0 // variable which decides the register is black or white
@KBD
D=M
@LOOP
D;JEQ
@KEYBOARD
0;JMP
(LOOP)
@j
D=M // value to be set in the correcponding register
@curr  // has the present column number
A=M // going to the register with column value
A=M // going to the corresponing column
M=D // changing color to black or white
@32 // changing the row for next loop by adding 32
D=A
@curr
A=M
M=M+D
@i    // keep track of row number
M=M+1 // incrementing row value
@256
D=A
@i
D=D-M
@CHANGE
D;JEQ
@LOOP
0;JMP
(CHANGE)
@i // reseeting row for next column
M=0
@curr
M=M+1 // incrementing upto 11
D=M
@12
D=D-A
@KEYBOARD
D;JGE // breaking statement
@LOOP
0;JMP
