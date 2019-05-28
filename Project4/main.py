import math

class DTree:
    def __init__(self):
        self.root = Node("")



class Node:

    def __init__(self, name):
        self.name = name
        self.left = ""
        self.right = ""


def printTree(node, level):
    for i in range(level):
        print("\t", end="")
    if node.name != "" and node != "":
        print("|_" + node.name)
    else:
        #print("-")
        return
    level += 1
    printTree(node.left, level)
    printTree(node.right, level)

def readData():
    data = open("data.txt")
    lines = data.readlines()
    all_data = list()
    for d in lines:
        d = d.replace("\n", "")
        features = d.split(" ")
        all_data.append(features)
    return all_data

def entropy(class0, class1, sample_size):
    if class0 == 0 or class1 == 0:
        return 0
    return (-1*(class0/sample_size)*math.log2(class0/sample_size)) - (class1/sample_size)*math.log2(class1/sample_size)

def calculateGains(data):
    info_gain = list()

    sample_size = len(data)
    for fNo in range(3):
        count_class1 = 0
        count_1 = 0
        count_1_1 = 0
        count_0_1 = 0
        for sample in data:
            if sample[fNo] == "1":
                count_1 += 1
                if sample[len(sample)-1] == "1":
                    count_1_1 += 1
            else:
                if sample[len(sample)-1] == "1":
                    count_0_1 += 1
            if sample[len(sample)-1] == "1":
                count_class1 += 1
        count_0 = sample_size-count_1
        count_1_0 = count_1-count_1_1
        count_0_0 = count_0 - count_0_1
        count_class0 = sample_size-count_class1

        class_entropy = entropy(count_class0, count_class1, sample_size)
        feature_entropy = (count_0/sample_size)*entropy(count_0_0, count_0_1, sample_size)+ (count_1/sample_size)*entropy(count_1_0, count_1_1, sample_size)
        feature_gain = class_entropy - feature_entropy
        info_gain.append((feature_gain, fNo+1))
        #print("Feature" + str(fNo+1) + "  " + str(count_0) + "-" + str(count_1))
    return info_gain

def getKey(tup):
    return tup[0]

def findMax(gains, selected_f):
    gains = sorted(gains, key=getKey, reverse=True)
    for g in gains:
        if g[1] not in selected_f:
            return g

def seperate_by_feature(data, fNo):
    list_0 = list()
    list_1 = list()
    for d in data:
        if d[fNo] == "1":
            list_1.append(d[len(d)-1])
        else:
            list_0.append(d[len(d)-1])
    print(set(list_1))
    print(set(list_0))

def generateDTree(data, level, r, selected_f):
    gains = calculateGains(data)
    if len(gains) > 0:
        max_feature = findMax(gains,selected_f)
        if max_feature is not None:
            selected_f.append(max_feature[1])
            gains.remove(max_feature)
        else:
            return
    else:
        return

    print("\t  ", end="")
    r.name = "F"+str(max_feature[1])
    print("F"+str(max_feature[1]))
    level += 1
    for i in range(level):
        print("\t", end="")
    print("___ ___")
    for i in range(level):
        print("\t", end="")
    print("|      |")


    list_0 = list()
    list_1 = list()
    for d in data:
        if d[max_feature[1]-1] == "1":
            list_1.append(d[len(d)-1])
        else:
            list_0.append(d[len(d)-1])

    for i in range(level):
        print("\t", end="")
    if len(set(list_0)) == 1:
        print(list_0[0], end="")
        r.left = Node(list_0[0])
        r.right = Node("")
        #print("0|___ " + list_0[0], end="")
        for d in data:
            if d[max_feature[1]-1] == "0":
                data.remove(d)
        if len(data) == 0:
            return
        else:
            generateDTree(data, level,  r.right, selected_f)
    elif len(set(list_1)) == 1:
        print(list_1[0])
        r.left = Node("")
        r.right = Node(list_1[0])
        #print("0|___ " + list_1[0])
        for d in data:
            if d[max_feature[1]-1] == "1":
                data.remove(d)
        if len(data) == 0:
            return
        else:
            generateDTree(data, level, r.left, selected_f)
    else:
        if len(data) == 0:
            return
        else:
            r.left = Node("")
            r.right = Node("")

            data_0 = list()
            data_1 = list()

            for d in data:
                if d[max_feature[1] - 1] == "0":
                    data_0.append(d)

            for d in data:
                if d[max_feature[1] - 1] == "1":
                    data_1.append(d)

            generateDTree(data_0, level, gains, r.left, selected_f)
            generateDTree(data_1, level, gains, r.right, selected_f)

    #gains.remove(max_feature)






data = readData()
tree = DTree()
generateDTree(data, 0, tree.root, list())
#printTree(tree.root, 0)