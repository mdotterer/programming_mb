#!/usr/bin/env ruby

require 'json'

questions = JSON.load(File.open("../questions.json"))

questions.each.with_index(1) do |question, i|
  puts "Question ##{i}\n"
  puts question['text']
  question['choices'].each.with_index('A'.ord) do |choice, letter|
    puts "#{letter.chr}) #{choice}"
  end
  puts "\n"
  print "Your Answer: "

  answer = gets.strip.upcase.ord - 'A'.ord

  if answer == question['answer']
    puts "Correct!"
  else
    puts "WRONG"
  end

  puts "\n\n"
end
