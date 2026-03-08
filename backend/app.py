
from flask import Flask, request, jsonify
from flask_cors import CORS
import joblib

app = Flask(__name__)
CORS(app)

model = joblib.load("model.pkl")

def extract_features(url):
    return [
        len(url),
        url.count('.'),
        url.count('-'),
        url.count('@'),
        url.count('?'),
        url.count('%')
    ]

@app.route("/predict", methods=["POST"])
def predict():
    data = request.get_json()
    url = data["url"]
    features = [extract_features(url)]
    prediction = model.predict(features)[0]

    if prediction == 1:
        result = "⚠️ Phishing Website Detected"
    else:
        result = "✅ Safe Website"

    return jsonify({"prediction": result})

if __name__ == "__main__":
    app.run(debug=True)
