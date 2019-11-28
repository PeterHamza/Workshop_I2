<!doctype html>

<title>Developpement</title>
<meta charset="utf-8"/>

<link rel="stylesheet" href="lib/codemirror.css">
<script src="lib/codemirror.js"></script>
<script src="addon/edit/matchbrackets.js"></script>
<link rel="stylesheet" href="addon/hint/show-hint.css">
<script src="addon/hint/show-hint.js"></script>
<script src="clike.js"></script>
<style>.CodeMirror {border: 2px inset #dee;}</style>
<div style="float:left; width: 48%; height: 500pt; border:solid; overflow:auto;">
  <p style="color: blue; font-weight:bold;">Objectif</p><br/>
Batman va rechercher les otages d'un batiment donné en sautant de fenêtre en fenêtre à l'aide de son grappin. Le but de Batman est d'arriver sur la fenêtre de la pièce où les otages se trouvent afin de désamorcer les bombes du Joker. Malheureusement il n'a qu'un nombre de sauts limités avant que les bombes n'explosent...<br/><br/>
  <p style="color: blue; font-weight:bold;">Règles</p><br/>
Avant chaque saut, le détecteur fournira à Batman la direction des bombes par rapport à la position actuelle de Batman:<br/>

    U (Up : les bombes sont situées au dessus de Batman)<br/>
    UR (Up-Right : les bombes sont situées au dessus et à droite de Batman)<br/>
    R (Right : les bombes sont situées à droite de Batman)<br/>
    DR (Down-Right : les bombes sont situées en dessous et à droite de Batman)<br/>
    D (Down : les bombes sont situées en dessous de Batman)<br/>
    DL (Down-Left : les bombes sont situées en dessous et à gauche de Batman)<br/>
    L (Left : les bombes sont situées à gauche de Batman)<br/>
    UL (Up-Left : les bombes sont situées au dessus et à gauche de Batman)<br/>


Votre mission consiste à programmer le détecteur afin qu'il indique la position de la fenêtre sur laquelle Batman devra se rendre au saut suivant de sorte qu'il atteigne les bombes le plus tôt possible.<br/>

Les bâtiments sont représentés par des rectangles de fenêtres, la fenêtre en haut à gauche a pour position (0,0).<br/><br/>
  <p style="color: blue; font-weight:bold;">Note</p>
Pour certains tests, la position des bombes varie d'une exécution à l'autre. L'objectif est de vous aider à trouver le meilleur algorithme possible.<br/>

Les tests fournis et les validateurs utilisés pour le calcul du score sont similaires mais différents.<br/><br/>
  <p style="color: blue; font-weight:bold;">Entrées du jeu</p><br/>
Le programme doit d'abord lire les données d'initialisation depuis l'entrée standard, puis, dans une boucle infinie, lire depuis l'entrée standard les données relatives à l'état courant de Batman et fournir sur la sortie standard les données demandées.<br/><br/>
<p style="color: blue; font-weight:bold;">Entrées d'initialisation</p><br/>

<div style="font-weight:bold;">Ligne 1 :</div> 2 entiers W H. Le couple (W, H) représente la largeur et la hauteur du batiment en nombre de fenêtres.<br/>

<div style="font-weight:bold;">Ligne 2 :</div> 1 entier N, qui représente le nombre de sauts que Batman peut faire avant que les bombes n'explosent.<br/>

<div style="font-weight:bold;">Ligne 3 :</div> 2 entiers X0 Y0, qui représentent la position de départ de Batman.<br/><br/>
<p style="color: blue; font-weight:bold;">Entrée pour un tour de jeu</p><br/>
La direction vers laquelle se trouve la bombe.<br/><br/>
<p style="color: blue; font-weight:bold;">Sortie pour un tour de jeu</p><br/>
Une ligne unique avec 2 entiers X Y séparés par un espace. (X, Y) représente la position de la prochaine fenêtre sur laquelle Batman devrait sauter. X représente l'index sur l'axe horizontal, Y représente l'index sur l'axe vertical. (0,0) se trouve dans le coin haut gauche du bâtiment.<br/><br/>
<p style="color: blue; font-weight:bold;">Contraintes</p><br/>
1 ≤ W ≤ 10000<br/>
1 ≤ H ≤ 10000<br/>
2 ≤ N ≤ 100<br/>
0 ≤ X, X0 < W<br/>
0 ≤ Y, Y0 < H<br/>
Temps de réponse pour un tour ≤ 150ms<br/>
Temps de réponse pour un tour ≤ 150ms<br/>

</div>
<article>

  <form method="POST" action="/" onsubmit="download()">
<div style="float:right;width:50%;">
    <textarea id="java-code">
class Program {
  public void main(String[] args) {
    System.out.println("Hello world")
  }
}</textarea></div>

    <input type="submit" style="float:right">
<p style="font-weight:bold;">Output</p>
<div style="float:right;width:50%">
<textarea id="code">
</textarea></div>
</form>
  <script>
  var javaEditor = CodeMirror.fromTextArea(document.getElementById("java-code"), {
      lineNumbers: true,
      matchBrackets: true,
      mode: "text/x-java"
  });
  var javaEditor = CodeMirror.fromTextArea(document.getElementById("code"), {
      lineNumbers: false,
      matchBrackets:false,
      mode: "text"
  });

  var mac = CodeMirror.keyMap.default == CodeMirror.keyMap.macDefault;
  CodeMirror.keyMap.default[(mac ? "Cmd" : "Ctrl") + "-Space"] = "autocomplete";
</script>
<script>
function download() {
    alert(document.getElementById('code').value)
    document.getElementById('code').value = 'Hello world'
}
  
var input = document.getElementById('java-code');
console.log(input.value);

</script>
</article>
