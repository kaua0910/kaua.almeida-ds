echo OFF

echo --- Retirando Usuario GitHUB ----

git config --global --unset-all user.email
git config --global --unset-all user.name

echo --- Configurando Usuario GitHUB ----

git config --global user.name "kaka"
git config --global user.email kaua.alameida0910@gmail.com
echo --- Mostrando a configuração atual do Github no computador

git config --list

git clone https://github.com/kaua0910/kaua.almeida-ds.git

pause