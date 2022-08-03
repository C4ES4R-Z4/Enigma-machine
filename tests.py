import subprocess

# Global defs
java_file = "Enigma.java"
java_class = "Enigma"

# Compiles the Java files
subprocess.check_call(['javac', java_file])

# Tests under default config
input_list = ["test1", "test2", "I got this from the Numberphile video", "https://www.youtube.com/watch?v=G2_Q9FoD-oQ"]
output_list = ["BQOP1", "BQOP2", "S HUH UQRJ IQGN FDI VTICUHIOPSI OKCDK", "VJNTR://VXA.CGKUVTI.MWI/XSHEB?W=K2_C9GYL-UU"]

for i, j in zip(input_list, output_list):
    proc = subprocess.Popen(['java', java_class], stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True)
    outs, _ = proc.communicate(i)
    print(f"Test -> {i}")
    print("Passed?", outs[:-1] == j, "\n")