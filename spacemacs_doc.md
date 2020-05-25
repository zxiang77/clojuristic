vim cheatsheet
C-R : redo
u: undo
hjkl: left down up right
p: put back
d: delete
r: replace
c: change
G: bottom of the buffer
gg: top of the buffer

%: matching parens

edit:
a/A: append after the cursor is on/ end of the line the cursor is on
r/R: replace single character/ remaining line
o/O: start a line after/ before the line the cursor is on of the line
y: yank (a.k.a copy)
p/P: put after cursor/ the line below the cursor (paste delete)
C-v: select mode/ visual mode

Moving:
0: move to beginning of the line
$: move to end of the line
w: move to next word
b: move back by 1 word

searching:
/<search term>
n: search again
N: search backward
substitute: :s/<search_term>/<substitute_term>/<g if wants to substitute globally on this line>
	:%s/... substitute in the whole buffer

external command:
:!<external_command>
command: :<line_number>

misc:
open new files in neotree:
-: open with vertical split
|: open with horizontal split
open terminal: SPC SPC term RET

TODO: Bayonne, 500 Bayonne Crossing Way
s Bayonne, 500 Bayonne Crossing Wayetup kube yaml file
test debugging with the new setup
setup the logging for all parts
generate yaml file from yaml template (helm ?)
