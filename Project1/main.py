
from copy import deepcopy


def goalCheck(board):
    for i in range(0, len(board)):
        for j in range(0, len(board)):
            if (i == len(board)-1 and j == len(board)-1 and board[i][j] != ' '):
                return False
            elif (i != len(board)-1 and j != len(board)-1 and board[i][j] != str(j + 3*i+1)):
                return False
    return True;

def printBoard(board):
    for i in range(0, len(board)):
        print(board[i][:])
    print("-----------------------")

def generateChilds(board, q, expanded, isStack):
    for i in range(0, len(board)):
        for j in range(0, len(board[i])):
            if board[i][j] == " ":
                spaceI = i
                spaceJ = j

    for moveI in range(-1, 2):
        child = deepcopy(board)
        if moveI != 0 and -1 < spaceI + moveI < len(board):
            child[spaceI][spaceJ] = child[spaceI + moveI][spaceJ]
            child[spaceI + moveI][spaceJ] = " "
            if child not in expanded:
                if isStack:
                    q.insert(0, child)
                else:
                    q.append(child)

    for moveJ in range(-1,2):
        child = deepcopy(board)
        if moveJ != 0 and -1 < spaceJ + moveJ < len(board):
            child[spaceI][spaceJ] = child[spaceI][spaceJ + moveJ]
            child[spaceI][spaceJ + moveJ] = " "
            if child not in expanded:
                if isStack:
                    q.insert(0, child)
                else:
                    q.append(child)

    return q

def BFS(board):
    q = list()
    expanded = list()
    q.append(board)
    while len(q)>0:
        currentState = q.pop()
        printBoard(currentState)
        expanded.append(currentState)
        #printBoard(currentState)
        if goalCheck(currentState):
            return currentState
        q = generateChilds(currentState, q, expanded, False)
    return -1

def DFS(board):
    s = list()
    expanded = list()
    s.insert(0, board)
    while len(s) > 0:
        currentState = s.pop(0)
        printBoard(currentState)
        expanded.append(currentState)
        #printBoard(currentState)
        if goalCheck(currentState):
            return currentState
        s = generateChilds(currentState, s, expanded, True)
    return -1

def DepthLimited(board, depthLim):
    s = list()
    sDepth = list()
    expanded = list()
    currentDepth = 0
    s.insert(0, board)
    sDepth.insert(0, 0)
    while len(s) > 0 and currentDepth <= depthLim:
        currentState = s.pop(0)
        currentDepth = sDepth.pop(0)
        expanded.append(currentState)
        if goalCheck(currentState):
            print("DEPTH :: " + str(currentDepth))
            return currentState
        numOfStates = len(s)
        s = generateChilds(currentState, s, expanded, True)
        for i in range(0, (len(s)-numOfStates)):
            sDepth.insert(0, currentDepth+1)
    return -1

def IterativeDeepening(board):
    currentDepth = 0
    while True:
        result = DepthLimited(board, currentDepth)
        if result != -1:
            return result
        currentDepth += 1

def BidirectionalSearch(board):

    return -1

def getInitial():
    file = open("initialState.txt")
    lines = file.readlines()
    size = int(lines[0])
    initial = [" "] * size
    print(size)
    for i in range(0, size):
        initial[i] = [" "]*size
        nums = lines[i+1].split(" ")
        for j in range(0, size):
            if nums[j] != "":
                initial[i][j] = nums[j].replace("\n","")
    return initial




initialState = getInitial()
print(initialState)
print(DFS(initialState))