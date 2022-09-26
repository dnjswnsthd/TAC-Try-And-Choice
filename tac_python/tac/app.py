from flask import Flask, request, render_template
import pandas as pd
import numpy as np
import pickle
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from transformers import BertModel, BertTokenizer
import insert.consume_crud as crud
from models.consume import ConsumeTable, Consume


app = Flask(__name__, static_url_path='', 
            static_folder='web/static',
            template_folder='web/templates')
@app.route("/excel")
def spring():
    model_path = "/content/kpfbert"  
    
    #Bert 바이너리가 포함된 디렉토리
    model = BertModel.from_pretrained(model_path, add_pooling_layer=False)
    tokenizer = BertTokenizer.from_pretrained(model_path)
    file = request.files['file']
    df = pd.read_excel(file)

    df
    tokenizer.tokenize(df['소분류'][0])
    df['token'] = ''

    for i in range(len(df)):
        df['token'][i] = tokenizer.tokenize(df['소분류'][i])

    df

    tokenizer.convert_tokens_to_ids(df['token'][0])

    df['id']=''
    for i in range(len(df)):
        df['id'][i] = tokenizer.convert_tokens_to_ids(df['token'][i])

    len(df[df['대분류 라벨']==1])

    nums = []
    for i in range(1, 23):
        nums.append(len(df[df['대분류 라벨']==i]))

    nums

    plt.plot(nums)

    for i in range(1, 23):
        lens = len(df[df['대분류 라벨']==i])
        if lens < 10:
            df.drop(df[df['대분류 라벨']==i].index, inplace=True)
    df

    df.reset_index(drop=True, inplace=True)

    df

    len(df['id'][0])

    len_ = [len(df['id'][i]) for i in range(len(df))]

    max = max(len_)

    for i in range(max):
        df[f'id_{i}'] = 0

    for i in range(len(df)):
        ids = df['id'][i]
        for j in range(len(ids)):
            df[f'id_{j}'][i] = ids[j]

    df

    df_train = df.drop(columns=['소분류', '대분류 라벨', '대분류','token', 'id'], axis=1)

    df_train

    X_train, X_test, y_train, y_test = train_test_split(df_train, df['대분류 라벨'], shuffle=True, random_state=10, test_size=0.3)

    

    rf = RandomForestClassifier(random_state=5)
    rf.fit(X_train, y_train)
    rf.predict(X_test)

    rf.score(X_test, y_test)

    with open('/content/drive/MyDrive/randomforest.dat', 'wb') as f:
        pickle.dump(rf, f)

    with open('/content/drive/MyDrive/randomforest.dat', 'rb') as f:
        model = pickle.load(f)

    model.score(X_test, y_test)

    model.predict(X_test)

    y_test

    test = y_test.to_list()

    pred = model.predict(X_test)

    index = pd.DataFrame(y_test).index.to_list()

    cats = []
    for i in range(len(index)):
        idx = index[i]
        cat = df['소분류'][idx]
        cats.append(cat)

    pd.options.display.max_rows = None
    pd.DataFrame({'소분류': cats, 'pred': pred, 'real': test})
    consume = ConsumeTable()
    crud.insert_consumeInfo(consume)
    
    return consume

if __name__ == '__main__':
    app.run(debug=False, host="127.0.0.1", port=5000)