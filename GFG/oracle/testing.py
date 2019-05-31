import os
import sys
import csv

#arg_1 = sys.argv[1]
#arg_2 = sys.argv[2]
os.system('javac CodeVJava.java')
os.system('java CodeVJava')
os.system('g++ CodeVC.cpp -o cplus')
os.system('./cplus')
# os.system('ls')
csv_file = open('cpp_outputs.csv', mode='r')
csv_reader = csv.DictReader(csv_file)
prev_val = '11.txt'
stop = True
with open('test.csv', mode='r') as csv_file2:
    csv_reader2 = csv.DictReader(csv_file2)
    # print(csv_reader2)
    for x_values, y_values in zip(csv_reader, csv_reader2):
        act_val = x_values["input"]
        if prev_val != act_val:
            if stop:
                print(f'Pass test ->{prev_val}')
                if x_values == y_values:
                    prev_val = act_val 
                    stop = True
            else:
                print(f'Fail test ->{prev_val}')
                if x_values == y_values:
                    prev_val = act_val 
                    stop = True
        if (x_values == y_values):
            #print(f'{x_values} vs {y_values}')
            #print(f'sou true{x_values["input"]}{x_values["posX"]}{x_values["posY"]} vs {y_values["input"]}{y_values["posX"]}{y_values["posY"]} ')
            prev_val = act_val 
        else:
            #print(f'sou falso{x_values["input"]}{x_values["posX"]}{x_values["posY"]}')
            prev_val = act_val 
            stop = False
            

    csv_file.close()



            #print("Pass")
        # print(f'we are the same {x_values["input"]}{x_values["posX"]} vs {y_values["posX"]}')