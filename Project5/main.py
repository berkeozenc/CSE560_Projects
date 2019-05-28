
bn_file = open("bn.txt").readlines()
states = {}
for i in range(0, len(bn_file)):

    if i == 0:
        num_of_edge = int(bn_file[i].replace("\n",""))
    else:
        f,t =  bn_file[i].replace("\n","").split(" ")
        f_probs = list()
        t_probs = list()
        if states.get(f) is None :
            probs_file = open(f + ".txt").readlines()
            for p in probs_file:
                pe = p.split(" ")
                given = "".join(pe[:len(pe)-1])
                prob = float(pe[len(pe)-1])
                f_probs.append((given, prob))
            states[f] = f_probs

        if states.get(t) is None :
            probs_file = open(t + ".txt").readlines()
            for p in probs_file:
                pe = p.split(" ")
                given = "".join(pe[:len(pe)-1])
                prob = float(pe[len(pe)-1])
                t_probs.append((given, prob))
            states[t] = t_probs



calc = ["a","b"]
calc = ["o", "!a", "!b", "c"]
res = 1

for c in calc:
    if "!" in c:
        c = c.replace("!","")
        probs = states.get(c)
        for p in probs:
            res *= 1- p[1]
    else:
        probs = states.get(c)
        for p in probs:
            res *= p[1]

print(res)



